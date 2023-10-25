document.getElementById('subbtn').addEventListener('click', postData);

async function postData() {
    const form = document.getElementById('myForm');
    const formData = new FormData(form);
    const formDataObject = {};

    formData.forEach((value, key) => {
        formDataObject[key] = value;
    });

    const url = '';
    const requestOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(formDataObject),
    };

    try {
        const response = await fetch(url, requestOptions);
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        const data = await response.json();
        console.log(data); // Do something with the response data
    } catch (error) {
        console.error('Error:', error);
    }
}