var BreakException = {};

$(document).ready(function () {

    $.soap({
        beforeSend: function (SOAPEnvelope) {
            console.log(SOAPEnvelope.toString());
        },
        envAttributes: {
            'xmlns:toul': "http://toulouse.miage.fr/"
        },
        url: "http://localhost:8080/WebServiceMecanicien/WebServiceMecanicien",
        noPrefix: false,
        appendMethodToURL: false,
        error: function (SOAPResponse) {
            console.log(SOAPResponse)// show error
            M.toast({html : 'Erreur'})
        }
    });

    $.soap({
        method: "toul:getQuaisFromStation",
        data: {
            ids: sessionStorage.getItem('idstation')
        },
        success: function (soapResponse) {
            var lists = soapResponse.toXML().getElementsByTagName("list")
            var i = 1
            Array.prototype.slice.call(lists).forEach(quai => {
                console.log(quai)
                console.log(quai.getElementsByTagName("navArrimée"))
                var navette = quai.getElementsByTagName("navArrimée")
                if (navette.length > 0) {
                    var status = navette[0].getElementsByTagName("prochaineRevision")[0].childNodes[0].nodeValue;
                    console.log(status)
                    if (status == "-1") {
                        var operations = navette[0].getElementsByTagName("operations");
                        try {
                            Array.prototype.slice.call(operations).forEach(ope => {
                                console.log(ope)
                                if(ope.getElementsByTagName("dateFin").length == 0) {
                                    var tr = "<tr id='revision" + i + "'>"
                                    tr = tr + "<td>Navette n°" + navette[0].getElementsByTagName("id")[0].childNodes[0].nodeValue + "</td>"
                                    tr = tr + "<td>" + quai.getElementsByTagName("codeQuai")[0].childNodes[0].nodeValue + "</td>"
                                    tr = tr + "<td><a onclick='terminerRevision(" + i + "," + ope.getElementsByTagName("id")[0].childNodes[0].nodeValue + ")' class='waves-effect waves-light btn blue darken-4'>VALIDER</a></td>"
                                    tr = tr + "</tr>"
                                    $("#table_revisions").append(tr);
                                    i++;
                                    throw BreakException;
                                }
                            })
                        } catch (e) {
                            if (e !== BreakException) throw e;
                        }   
                    }
                }

            });
        }
    })
})

function terminerRevision(index, idr) {
    $.soap({
        method : "toul:finaliserRevision",
        data : {
            idr : idr
        },
        success : function(soapResponse) {
            $("#revision" + index).remove()
            M.toast({html: 'Révision selectionnée'})       
        }
    })
}