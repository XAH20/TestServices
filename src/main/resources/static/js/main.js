var stompClient = null;

function setConnectedMonthService(connected) {
    document.getElementById('connectMonthService').disabled = connected;
    document.getElementById('disconnectMonthService').disabled = !connected;
    document.getElementById('conversationDivMonth').style.visibility = connected ? 'visible' : 'hidden';
    document.getElementById('responseMonth').innerHTML = '';
}

function connectMonthService() {
    var socket = new SockJS('/ws', );
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnectedMonthService(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/month', function (monthResp) {
            showRespMonth(JSON.parse(monthResp.body).content);
        });
    });
}

function disconnectMonthService() {
    stompClient.disconnect();
    setConnectedMonthService(false);
    console.log("Disconnected");
}

function sendMonth() {
    var month = document.getElementById('month').value;
    stompClient.send("/app/getMonth", {}, JSON.stringify({'month': month}));
}

function showRespMonth(message) {
    var response = document.getElementById('responseMonth');
    var p = document.createElement('p');
    p.style.wordWrap = 'break-word';
    p.appendChild(document.createTextNode("Вы ввели: " + document.getElementById('month').value + ". Ответ: " + message));
    response.appendChild(p);
}

function setConnectedStringsService(connected) {
    document.getElementById('connectStringsService').disabled = connected;
    document.getElementById('disconnectStringsService').disabled = !connected;
    document.getElementById('conversationDivStrings').style.visibility = connected ? 'visible' : 'hidden';
    document.getElementById('responseStrings').innerHTML = '';
}

function connectStringsService() {
    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnectedStringsService(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/strings', function (stringsResp) {
            showRespStrings(JSON.parse(stringsResp.body).content);
        });
    });
}

function disconnectStringsService() {
    stompClient.disconnect();
    setConnectedStringsService(false);
    console.log("Disconnected");
}

function sendStrings() {
    var strings = document.getElementById('strings').value;
    stompClient.send("/app/sortStrings", {}, JSON.stringify({'strings': strings}));
}

function showRespStrings(message) {
    var response = document.getElementById('responseStrings');
    var p = document.createElement('p');
    p.style.wordWrap = 'break-word';
    p.appendChild(document.createTextNode("Ответ: " + message));
    response.appendChild(p);
}