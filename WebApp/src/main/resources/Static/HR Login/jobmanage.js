//jobpost.html
async function postDataToAPI() {
    const form = document.getElementById("jobPostForm");
    const formData = new FormData(form);
  
    const apiUrl = "";  //place the api to post data
  
    try {
      const response = await fetch(apiUrl, {
        method: "POST",
        body: formData,
      });
  
      if (response.ok) {
        const responseData = await response.json();
        console.log("Response from API:", responseData);
      } else {
        console.error("Error posting data to API:", response.statusText);
      }
    } catch (error) {
      console.error("Error:", error);
    }
  }
  
  const submitButton = document.getElementById("postjob");
  submitButton.addEventListener("click", async function (e) {
    e.preventDefault(); 
    await postDataToAPI(); 
  });
  


//applicant.html





//getting data form api

// async function fetchApplicantData() {
//     try {
//       const response = await fetch(''); //place the api in it
//       if (!response.ok) {
//         throw new Error('Failed to fetch data');
//       }
  
//       const data = await response.json();
  
//       const tbody = document.getElementById('applicantlist');
  
//       tbody.innerHTML = '';
  
//       data.forEach((applicant, index) => {
//         const row = document.createElement('tr');
  
//         const snoCell = document.createElement('td');
//         snoCell.textContent = index + 1;
  
//         const nameCell = document.createElement('td');
//         nameCell.textContent = applicant.name;
  
//         const contactNoCell = document.createElement('td');
//         contactNoCell.textContent = applicant.contactNo;
  
//         const emailCell = document.createElement('td');
//         emailCell.textContent = applicant.email;
  
//         const qualificationCell = document.createElement('td');
//         qualificationCell.textContent = applicant.qualification;
  
//         const locationCell = document.createElement('td');
//         locationCell.textContent = applicant.location;
  
//         const applyDateCell = document.createElement('td');
//         applyDateCell.textContent = applicant.applyDate;
  
//         row.appendChild(snoCell);
//         row.appendChild(nameCell);
//         row.appendChild(contactNoCell);
//         row.appendChild(emailCell);
//         row.appendChild(qualificationCell);
//         row.appendChild(locationCell);
//         row.appendChild(applyDateCell);
  
//         tbody.appendChild(row);
//       });
//     } catch (error) {
//       console.error('Error fetching data:', error);
//     }
//   }
  
//   fetchApplicantData();

  