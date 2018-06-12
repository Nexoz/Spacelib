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
            M.toast("Login déjà existant")
        }
    });

    $("#btn_register").click(function (evt) {
        evt.preventDefault();
        // Call function login
        // Mise en variable session de l'user id
        var surname = $("#surname").val(); 
        var name = $("#name").val(); 
        var login = $("#login").val();
        var password = $("#password").val();

        if(login !== "" && password !== "" && name !== "" && surname !== "") {
            $.soap({
                method : "toul:creerUsager",
                data : {
                    surname : surname,
                    name : name,
                    login : login,
                    password : password
                },
    
                success: function (soapResponse) {
                    var xmlDoc = soapResponse.toXML()
                    console.log(soapResponse.toXML().getElementsByTagName("return")[0].childNodes[0].nodeValue)

                    sessionStorage.setItem('userid', xmlDoc.getElementsByTagName("return")[0].childNodes[0].nodeValue);
                    sessionStorage.setItem('username', name);
                    window.location = "home.html";
                }
            })
        }
    })
})