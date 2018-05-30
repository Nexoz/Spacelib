$(document).ready(function() {

    var station_select = `
    <div class='row'>
        <div class="input-field col m10 offset-m1">
            <select>
                <option value="" disabled selected>Choose your option</option>
                <option value="1">Option 1</option>
                <option value="2">Option 2</option>
                <option value="3">Option 3</option>
            </select>
            <label>Materialize Select</label>
        </div>
    </div>`;

    $("#login").click(function (evt) {
        evt.preventDefault();
        $("#form_container").html(station_select);
        $('select').formSelect();      
    })
})