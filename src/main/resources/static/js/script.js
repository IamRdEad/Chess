document.addEventListener('DOMContentLoaded', function() {
    var stompClient = null;

    function connect() {
        var socket = new SockJS('/ws');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/Response', function (response) {
                showResponse(JSON.parse(response.body));
            });
        });
    }

    function showResponse(message) {
        console.log('Message content: ', message.content);
        alert(message.content);
    }

    connect();

    document.getElementById('signupBtn').addEventListener('click', function() {
        document.querySelector('.welcome').classList.add('hidden');
        document.getElementById('registrationForm').classList.remove('hidden');
    });

    document.getElementById('backBtn').addEventListener('click', function() {
        document.querySelector('.welcome').classList.remove('hidden');
        document.getElementById('registrationForm').classList.add('hidden');
    });

    document.querySelector('form').addEventListener('submit', function(event) {
        event.preventDefault();
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        var email = document.getElementById("email").value;

        stompClient.send("/app/signup", {}, JSON.stringify({
            'username': username,
            'password': password,
            'email': email
        }));

        document.querySelector('.welcome').classList.remove('hidden');
        document.getElementById('registrationForm').classList.add('hidden');
    });
});
