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