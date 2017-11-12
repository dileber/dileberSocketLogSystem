var ws = null;
var url = null;
var transports = [];

function setConnected(connected) {
    document.getElementById('conline').disabled = connected;
    document.getElementById('disconline').disabled = !connected;
}

function connect() {
    alert("url:" + url);
    if (!url) {
        alert('Select whether to use W3C WebSocket or SockJS');
        return;
    }
    if (url.indexOf("sockjs")!=-1){
        log("hhhhhhhh");
        ws = new SockJS(url);
    }else {
        if ('WebSocket' in window) {
            ws = new WebSocket(url);//ws://localhost:8080/myHandler
        } else {
            ws = new SockJS(url);
        }
    }


    ws.onopen = function () {
        setConnected(true);
        log('Info: connection opened.');
    };
    ws.onmessage = function (event) {
        log('Received: ' + event.data);
    };
    ws.onclose = function (event) {
        setConnected(false);
        log('Info: connection closed.');
        log(JSON.stringify(event));
    };
}



function echo() {
    if (ws != null) {
        var message = document.getElementById('message').value;
        log('Sent: ' + message);
        ws.send(message);
    } else {
        alert('connection not established, please connect.');
    }
}

function updateUrl(urlPath) {
    if (urlPath.indexOf("/sockjs")!=-1){
        url = 'http://'+ window.location.host + urlPath + "?userId="+"15620693394";
    }else{
        if (window.location.protocol == 'http:') {
            url = 'ws://' + window.location.host + urlPath+ "?userId="+"15620693394";
        } else {
            url = 'wss://' + window.location.host + urlPath+ "?userId="+"15620693394";
        }
    }
    console.log(url)
}

function updateTransport(transport) {
    alert(transport);
    transports = (transport == 'all') ? [] : [transport];
}

function log(message) {
    var console = document.getElementById('console');
    var p = document.createElement('p');
    p.style.wordWrap = 'break-word';
    p.appendChild(document.createTextNode(message));
    console.appendChild(p);
    while (console.childNodes.length > 850) {
        console.removeChild(console.firstChild);
    }
    console.scrollTop = console.scrollHeight;
}
var chars = ['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];

function generateMixed(n) {
    var res = "";
    for(var i = 0; i < n ; i ++) {
        var id = Math.ceil(Math.random()*35);
        res += chars[id];
    }
    return res;
}

function conline() {
    var userId = document.getElementById('userId').value;
    var url = 'http://' + window.location.host + '/sockjs/myHandler'+ "?userId=log"+userId;
    console.log("I am %s and I have:", url);
    ws = new SockJS(url);
    ws.onopen = function () {
        setConnected(true);
        log('Info: connection opened.');
    };
    ws.onmessage = function (event) {
        log( event.data);
    };
    ws.onclose = function (event) {
        setConnected(false);
        log('Info: connection closed.');
        log(JSON.stringify(event));
    };
    alert('开启日志');

}

function disconnect() {
    if (ws != null) {
        ws.close();
        ws = null;
    }
    setConnected(false);
}

function disconline() {
    if (ws != null) {
        ws.close();
        ws = null;
    }
    setConnected(false);
}