$(document).ready(function () {

    // Config
    $.soap({
        beforeSend: function(SOAPEnvelope) {
            console.log(SOAPEnvelope.toString());
        },
        envAttributes: {
            'xmlns:toul': "http://toulouse.miage.fr/"
        },
        url : "http://localhost:8080/WebServiceMecanicien/WebServiceMecanicien",
        noPrefix : false,
        appendMethodToURL : false,
        error: function (SOAPResponse) {
            console.log(SOAPResponse)// show error
        }
    });

    // Récupération des Quais/Navettes pour la station en cours
    $.soap({
        method : "toul:getQuaisFromStation",
        data : {
            ids : sessionStorage.getItem('idstation')
        },
        success : function(soapResponse) {
            var lists = soapResponse.toXML().getElementsByTagName("list")
            Array.prototype.slice.call(lists).forEach(quai => {
                console.log(quai)
                console.log(quai.getElementsByTagName("navArrimée"))
                var navette = quai.getElementsByTagName("navArrimée")
                // Si une navette est arrimée
                if(navette.length > 0) {
                    // Génération du tr
                    var tr = "<tr>"
                    tr = tr + "<td>Navette n°" + navette[0].getElementsByTagName("id")[0].childNodes[0].nodeValue + "</td>"
                    tr = tr + "<td>" + quai.getElementsByTagName("codeQuai")[0].childNodes[0].nodeValue + "</td>"
                    var status = navette[0].getElementsByTagName("prochaineRevision")[0].childNodes[0].nodeValue;
                    console.log(status)
                    switch(status) {
                        case '3' :
                            tr = tr + "<td colspan='2'> 3 voy. restants</td><td><a class='waves-effect waves-light btn blue darken-4' disabled>REVISER</a></td>"
                            tr = tr + "</tr>"
                            $("#table_navettes").append(tr);
                            break;
                        case '1', '2' :
                            tr = tr + "<td colspan='2'> " + status + " voy. restants</td><td><a class='waves-effect waves-light btn blue darken-4'>REVISER</a></td>"
                            tr = tr + "</tr>"
                            $("#table_navettes").append(tr);
                            break;
                        case '0' :
                            tr = tr + "<td class='red-text' colspan='2'>Révision nécessaire</td><td><a class='waves-effect waves-light btn blue darken-4'>REVISER</a></td>"
                            tr = tr + "</tr>"
                            $("#table_navettes").append(tr);
                            break;
                        default : break;
                    }
                }
                
            });
        }
    })
    
})