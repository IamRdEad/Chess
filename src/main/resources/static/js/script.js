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
        console.log('Message content: ', message.content + "" +"\nMessage code: " + message.code ) ;
        alert(message.content);
        if(message.code === 200){
            window.location.href='../chessboard.html';
        }
    }

    connect();

    const signupBtn = document.getElementById('signupBtn');
    const signinBtn = document.getElementById('signinBtn');
    const signupForm = document.getElementById('signupForm');
    const signingForm = document.getElementById('signingForm');

    if (signupBtn) {
        signupBtn.addEventListener('click', function() {
            document.querySelector('.welcome').classList.add('hidden');
            document.getElementById('registrationForm').classList.remove('hidden');
        });
    }

    if (signinBtn) {
        signinBtn.addEventListener('click', function() {
            document.querySelector('.welcome').classList.add('hidden');
            document.getElementById('loginForm').classList.remove('hidden');
        });
    }

    document.querySelectorAll('.backBtn').forEach(function(btn) {
        btn.addEventListener('click', function() {
            document.querySelector('.welcome').classList.remove('hidden');
            document.getElementById('registrationForm').classList.add('hidden');
            document.getElementById('loginForm').classList.add('hidden');
        });
    });

    if (signupForm) {
        signupForm.addEventListener('submit', function(event) {
            event.preventDefault();
            var username = document.getElementById("signup-username").value;
            var password = document.getElementById("signup-password").value;
            var email = document.getElementById("signup-email").value;

            stompClient.send("/app/signup", {}, JSON.stringify({
                'username': username,
                'password': password,
                'email': email
            }));

            document.querySelector('.welcome').classList.remove('hidden');
            document.getElementById('registrationForm').classList.add('hidden');
        });
    }

    if (signingForm) {
        signingForm.addEventListener('submit', function(event) {
            console.log("hello")
            event.preventDefault();
            var username = document.getElementById("login-username").value;
            var password = document.getElementById("login-password").value;

            stompClient.send("/app/signin", {}, JSON.stringify({
                'username': username,
                'password': password
            }));

            document.querySelector('.welcome').classList.remove('hidden');
            document.getElementById('loginForm').classList.add('hidden');
        });
    }
});
