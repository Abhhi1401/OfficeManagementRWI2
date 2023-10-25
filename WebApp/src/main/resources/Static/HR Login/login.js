document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('myForm');
    const usernameInput = document.getElementById('username');
    const passwordInput = document.getElementById('password');

    form.addEventListener('submit', function (e) {
        e.preventDefault(); 

        const username = usernameInput.value;
        const password = passwordInput.value;

        const apiEndpoint = 'http://localhost:8080/HR/login'; // Replace with your API endpoint

        const data = {
            username: username,
            password: password
        };

        fetch(apiEndpoint, {
            method: 'POST',
            headers : {
				 'Content-Type': 'application/json'
			},
            body: JSON.stringify(data)
        })
            .then(response => response.json())
            .then(responseData => {
                window.location.href = './emplist.html';
                console.log('API response:', responseData);
            })
            .catch(error => {
                console.error('Error:', error);
            });
    });
});


