$(document).ready(function () {

    $.soap({
        beforeSend: function (SOAPEnvelope) {
            console.log(SOAPEnvelope.toString());
        },
        envAttributes: {
            'xmlns:toul': "http://toulouse.miage.fr/"
        },
        url: "http://localhost:8080/WebServiceReservationUsager/WebServiceReservationUsager",
        noPrefix: false,
        appendMethodToURL: false,
        error: function (SOAPResponse) {
            console.log(SOAPResponse)// show error
        }
    })

    $.soap({
        method: "toul:getListStations",
        url: "http://localhost:8080/WebServiceMecanicien/WebServiceMecanicien",
        data: {},
        success: function (soapResponse) {
            console.log(soapResponse.toXML())
            var root = soapResponse.toXML().getElementsByTagName("list");
            for (var i = 0; i < root.length; i++) {
                var value = root[i].getElementsByTagName("id")[0].childNodes[0].nodeValue
                var text = root[i].getElementsByTagName("nom")[0].childNodes[0].nodeValue
                $("#station_dep").append($('<option>', {
                    value: value,
                    text: text
                }))
                $("#station_arr").append($('<option>', {
                    value: value,
                    text: text
                }))
            }
            $('select').formSelect();
        }
    })

    $("#reserverform").change(function () {
        if ($("#datedepart").val() != "" && $("#station_dep").val() != null && $("#station_arr").val() != null) {
            console.log($("#datedepart").val())
            
            var stationd = $('#station_dep').find(":selected").text();
            var stationa = $('#station_arr').find(":selected").text();
            console.log(stationd + ' ' + stationa)
            $.soap({
                method: "toul:calculerDistance",
                data: {
                    nomStationD : stationd,
                    nomStationA : stationa
                },
                success: function (soapResponse) {
                    console.log(soapResponse.toXML())
                    console.log();
                    var day = moment($("#datedepart").val(), "DD/MM/YY");
                    day.add(soapResponse.toXML().getElementsByTagName("return")[0].childNodes[0].nodeValue, 'days')
                    $("#datearrivee").val(day.format("DD/MM/YY"));
                }
            })
            if($("#nbpassagers").val() != null) {
                $("#submit").prop("disabled", false);
            } else {
                $("#submit").prop("disabled", true);   
            }
        } else {
            $("#submit").prop("disabled", true);
        }
    })

    $("#nbpassagers").change(function () {
        if ($("#nbpassagers").val() != null && $("#datedepart").val() != "" && $("#station_dep").val() != null && $("#station_arr").val() != null) {
            $("#submit").prop("disabled", false);
        } else {
            $("#submit").prop("disabled", true);
        }
    })
})