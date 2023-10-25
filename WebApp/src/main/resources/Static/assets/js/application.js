//get data from api - application page.
async function fetchDataFromAPI() {
  try {
    const response = await fetch('http://localhost:8080/jobs/list');
    const jsonData = await response.json();
    return jsonData;
  } catch (error) {
    console.error('Error fetching data:', error);
    return null;
  }
}
async function populateData() {
  const jsonData = await fetchDataFromAPI();

  if (jsonData) {
    const url = new URL(window.location.href);
    const id = url.searchParams.get('id');

    if (id) {
      const selectedData = jsonData.find(item => item.jobId === parseInt(id, 10));

      if (selectedData) {
        document.getElementById('1').textContent = selectedData.jobTitle;
        document.getElementById('2').textContent = selectedData.skills;
        document.getElementById('3').textContent = selectedData.minExp;
        document.getElementById('4').textContent = selectedData.noOfReq;
        document.getElementById('5').textContent = selectedData.jobPostedDate;
        document.getElementById('5').textContent = selectedData.jobLastDate;
        document.getElementById('6').textContent = selectedData.domain;
        document.getElementById('7').textContent = selectedData.salRange;
        document.getElementById('8').textContent = selectedData.jobQual;
        document.getElementById('9').textContent = selectedData.jobType;
        document.getElementById('10').textContent = selectedData.jobDesc;

      } else {
        console.log('No data found for the given ID.');
      }
    } else {
      console.log('No ID parameter in the URL.');
    }
  }
}
populateData();


// Step 1: Submit button click event
document.getElementById('otpbtn').addEventListener('click', async function (event) {
  event.preventDefault(); // Prevent form submission

  // Step 1: Check if all input fields are filled
  var firstName = document.getElementById('firstName').value.trim();
  var lastName = document.getElementById('lastName').value.trim();
  var email = document.getElementById('email').value.trim();
  var conDet = document.getElementById('conDet').value.trim();
  var address = document.getElementById('address').value.trim();
  var qualDetails = document.getElementById('qualDetails').value.trim();
  var dOB = document.getElementById('dOB').value.trim();
  var exp = document.getElementById('exp').value.trim();
  var passYear = document.getElementById('passYear').value.trim();
  var file = document.getElementById('resumeFile');
       file =     file.files[0];
       
       const formData = new FormData();
      formData.append("applicantData", JSON.stringify({
        'firstName':firstName,
        'lastName': lastName,
        'email': email,
        'contactDetails':conDet,
        'address':address,
        'qualDetails':qualDetails,
        'dOB':dOB,
        'exp':exp,
        'passYear':passYear
      }))
      formData.append('file', file);

  if (
    firstName === '' ||
    lastName === '' ||
    email === '' ||
    conDet === '' ||
    address === '' ||
    qualDetails === '' ||
    dOB === '' ||
    exp === '' ||
    passYear === '' ||
    file == null
  ) {
    alert('Please fill in all required fields');
  } else {
    try {
      const response = await fetch('http://localhost:8080/api/applicants', {
        method: 'POST',
        body: formData,
      });

      if (response.status === 200) {
        $('#otpsectionModal').modal('show');
        startTimer();
      } else {
        alert('Failed to submit data. Please try again.');
      }
    } catch (error) {
      console.error('Error submitting data:', error);
      alert('An error occurred while submitting data. Please try again.');
    }
  }
});


$('#otpsectionModal').on('hidden.bs.modal', function () {
  stopTimer();
});


var countdown;
function startTimer() {
    var duration = 300; 
    var timerDisplay = document.getElementById('countdown');

    var timer = duration, minutes, seconds;
    countdown = setInterval(function () {
        minutes = parseInt(timer / 60, 10);
        seconds = parseInt(timer % 60, 10);

        minutes = minutes < 10 ? '0' + minutes : minutes;
        seconds = seconds < 10 ? '0' + seconds : seconds;

        timerDisplay.textContent = minutes + ':' + seconds;

        if (--timer < 0) {
            // Step 4: Show "Resend OTP" button after timer ends
            document.getElementById('resendButton').style.display = 'block';
            stopTimer();
        }
    }, 1000);
}

// Step 5: Resend OTP button click event
document.getElementById('resendButton').addEventListener('click', function () {
  // Step 5: Send a POST request to request a new OTP from the API
  fetch('http://localhost:8080/api/resend-otp', {
      method: 'POST',
      body: formData
  })
  .then(function (response) {
      if (response.status === 200) {
          startTimer();
          document.getElementById('resendButton').style.display = 'none';
      } else {
          alert('Failed to resend OTP. Please try again.');
      }
  });
});

// Step 6: Verify OTP button click event
document.getElementById('verifyOTPButton').addEventListener('click', function () {
  var enteredOTP = document.getElementById('otpInput').value;

  // Step 6: Send the entered OTP to the API for verification
  fetch('http://localhost:8080/api/verify', {
      method: 'POST',
      body: new FormData(document.getElementById('otpForm')),
  })
  .then(function (response) {
      if (response.status === 200) {
          // OTP verification successful
          $('#otpsectionModal').modal('hide'); // Close OTP modal
          $('#successModal').modal('show'); // Show success modal
      } else {
          alert('OTP verification failed. Please try again.');
      }
  });
});

// Function to stop the timer
function stopTimer() {
  clearInterval(countdown);
}
