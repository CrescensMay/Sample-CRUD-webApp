var request = new XMLHttpRequest();

function searchEmployee() {
    var name = document.searchForm.search.value;
    var url = "index.jsp?val=" + name;

    try {
        request.onreadystatechange = function () {
            if (request.readyState === 4) {
                document.getElementById('location').innerHTML = request.responseText;
            }
        };
    request.open("GET", url,true);
    request.send();
    }catch (e){
        alert('Sorry could not to connect to the server!');
    }

}