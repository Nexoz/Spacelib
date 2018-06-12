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
        method: "toul:getReservationsForUsager",
        data: {
            idUsager: sessionStorage.getItem('userid')
        },
        success: function (soapResponse) {
            console.log(soapResponse.toXML())
            var lists = soapResponse.toXML().getElementsByTagName("list")
            var i = 1
            Array.prototype.slice.call(lists).forEach(resa => {
                console.log(resa)
                console.log(resa.getElementsByTagName("id"))

                var id = resa.getElementsByTagName("id")[0].childNodes[0].nodeValue;
                var deb = moment(resa.getElementsByTagName("dateDebut")[0].childNodes[0].nodeValue);
                var end = resa.getElementsByTagName("dateFin")
                
                var tr = "<tr id='resa" + i + "'>"
                tr = tr + "<td>#" + id + "</td>"
                tr = tr + "<td>" + deb.format("DD/MM/YY") + "</td>"

                if (end.length > 0) {
                    end = moment(end[0].childNodes[0].nodeValue);
                    tr = tr + "<td>" + end.format("DD/MM/YY") + "</td>"
                    tr = tr + "<td><button class='waves-effect waves-light btn red darken-1' disabled>ANNULER</button><td>"
                } else {
                    tr = tr + "<td>Plannifié</td>"
                    tr = tr + "<td><button onclick='annulerResa(" + i + "," + id + ") class='waves-effect waves-light btn red darken-1'>ANNULER</button><td>"
                }
                tr = tr + "</tr>"
                $("#table_resa").append(tr);
                i++;
            })
        }
    })
})

function annulerResa(index, idr){

}