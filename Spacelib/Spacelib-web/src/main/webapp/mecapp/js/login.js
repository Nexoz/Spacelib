$(document).ready(function() {

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
                    <option value="" disabled selected>Choisir une station</option>
                </select>
                <label>Station de rattachement</label>
            </div>
        </div>


        <br />
        <center>
        <div class='row'>
            <button id='submit' name='btn_submit' class='col m10 offset-m1 btn btn-large waves-effect indigo' disabled>Choisir</a>
        </div>
        </center>
    </form>`;

    $("#btn_login").click(function (evt) {
        evt.preventDefault();

        var login = $("#login").val();
        var password = $("#password").val();

        if(login !== "" && password !== "") {
            $.soap({
                method : "toul:authentifierMecanicien",
                data : {
                    login : login,
                    password : password
                },
    
                success: function (soapResponse) {
                    var xmlDoc = soapResponse.toXML()
                    console.log(soapResponse.toXML())

                    sessionStorage.setItem('idmecanicien', xmlDoc.getElementsByTagName("id")[0].childNodes[0].nodeValue);

                    $.soap({
                        method : "toul:getListStations",
                        data : {},
                        success : function(soapResponse) {
                            $("#form_container").html(station_select);
                            $("#form_container").hide()
                            var sel = $(station_select).find("#station_dropdown");
                            var root = soapResponse.toXML().getElementsByTagName("list");
                            for (var i=0; i < root.length; i++) {
                                console.log(root[i])
                                $("#station_dropdown").append($('<option>', {
                                    value : root[i].getElementsByTagName("id")[0].childNodes[0].nodeValue,
                                    text : root[i].getElementsByTagName("nom")[0].childNodes[0].nodeValue
                                }))
                            }
                            $("#form_container").show();
                            $('select').formSelect();   
                            $("#station_dropdown").change(function() {
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
                        }
                    })
                }
            })
        }
    })
})