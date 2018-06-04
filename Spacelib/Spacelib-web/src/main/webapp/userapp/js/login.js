$(document).ready(function() {

    $.soap({
        beforeSend: function(SOAPEnvelope) {
            console.log(SOAPEnvelope.toString());
        },
        envAttributes: {
            'xmlns:toul': "http://toulouse.miage.fr/"
        },
        url : "http://localhost:8080/WebServiceReservationUsager/WebServiceReservationUsager",
        noPrefix : false,
        appendMethodToURL : false,
        error: function (SOAPResponse) {
            console.log(SOAPResponse)// show error
        }
    });

    $("#btn_login").click(function (evt) {
        evt.preventDefault();
        // Call function login
        // Mise en variable session de l'user id
        var login = $("#login").val();
        var password = $("#password").val();

        if(login !== "" && password !== "") {
            $.soap({
                method : "toul:authentifier",
                data : {
                    login : login,
                    password : password
                },
    
                success: function (soapResponse) {
                    var xmlDoc = soapResponse.toXML()
                    console.log(soapResponse.toXML())

                    sessionStorage.setItem('userid', xmlDoc.getElementsByTagName("id")[0].childNodes[0].nodeValue);
                    sessionStorage.setItem('username', xmlDoc.getElementsByTagName("prenom")[0].childNodes[0].nodeValue);
                    window.location = "home.html";
                }
            })
        }
    })
})