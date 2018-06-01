$(document).ready(function() {

    var station_select = `
    <form id="stationform" action="home.html" class="col m12" method="get">
        <div class='row'>
        <div class='col m12'>
            <h5>Veuillez choisir votre station</h5>
        </div>
        </div>


        <div class='row'>
            <div class="input-field col m10 offset-m1">
                <select id="station_dropdown">
                    <option value="" disabled selected>Choose your option</option>
                    <option value="1">Sard17</option>
                    <option value="2">Monzbi</option>
                    <option value="3">MVtuite</option>
                </select>
                <label>Materialize Select</label>
            </div>
        </div>


        <br />
        <center>
        <div class='row'>
            <button id='submit' name='btn_submit' class='col m10 offset-m1 btn btn-large waves-effect indigo' disabled>Choisir</a>
        </div>
        </center>
    </form>`;

    $("#login").click(function (evt) {
        evt.preventDefault();

        // Call function login qui récupère l'id mecano
        $.soap({
            beforeSend: function(SOAPEnvelope) {
                console.log(SOAPEnvelope.toString());
            },
            HTTPHeaders: {
                'Access-Control-Allow-Origin': '*'
            },
            envAttributes: {
                'xmlns:toul': "http://toulouse.miage.fr/"
            },
            url : "http://localhost:8080/WebServiceMecanicien/WebServiceMecanicien?WSDL",
            noPrefix : false,
            appendMethodToURL : false,
            method : "toul:authentifierMecanicien",
            data : {
                login : "mistermv",
                password : "monzbi"
            },

            success: function (soapResponse) {
                console.log(soapResponse.toJSON())
                // do stuff with soapResponse
                // if you want to have the response as JSON use soapResponse.toJSON();
                // or soapResponse.toString() to get XML string
                // or soapResponse.toXML() to get XML DOM
            },
            error: function (SOAPResponse) {
                // show error
            }
        })

        /*
        var login = true;
        if(login){
            var idmecano = 1;
            sessionStorage.setItem('idmecanicien', idmecano);

            $("#form_container").html(station_select);
            $('select').formSelect();   
            $("#station_dropdown").change(function() {
                console.log($(this).val())
                if ($(this).val() !== "") {
                    $("#submit").prop("disabled", false);
                } else {
                    $("#submit").prop("disabled", true);
                }
            })
            $("#submit").click(function () {
                sessionStorage.setItem('idstation', $("#station_dropdown").val());
                sessionStorage.setItem('nomstation', $("#station_dropdown :selected").text());
            })   
        }*/
    })
})