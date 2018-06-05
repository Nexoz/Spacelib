$(document).ready(function () {

    var stations = {}

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
            $("#station_dep").change(function () {
                if ($(this).val() !== "" && $("#station_arr").val() !== "") {
                    $("#submit").prop("disabled", false);
                } else {
                    $("#submit").prop("disabled", true);
                }
            })
            $("#station_arr").change(function () {
                if ($(this).val() !== "" && $("#station_arr").val() !== "") {
                    $("#submit").prop("disabled", false);
                } else {
                    $("#submit").prop("disabled", true);
                }
            })
        }
    })
})