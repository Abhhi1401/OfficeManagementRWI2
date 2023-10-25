'use strict';

/**
 * add event on element
 */

const addEventOnElem = function (elem, type, callback) {
  if (elem.length > 1) {
    for (let i = 0; i < elem.length; i++) {
      elem[i].addEventListener(type, callback);
    }
  } else {
    elem.addEventListener(type, callback);
  }
}



/**
 * navbar toggle
 */

const navbar = document.querySelector("[data-navbar]");
const navTogglers = document.querySelectorAll("[data-nav-toggler]");
const navLinks = document.querySelectorAll("[data-nav-link]");
const overlay = document.querySelector("[data-overlay]");

const toggleNavbar = function () {
  navbar.classList.toggle("active");
  overlay.classList.toggle("active");
}

addEventOnElem(navTogglers, "click", toggleNavbar);

const closeNavbar = function () {
  navbar.classList.remove("active");
  overlay.classList.remove("active");
}

addEventOnElem(navLinks, "click", closeNavbar);



/**
 * carousel section script
 */

var counter = 1;
setInterval(function () {
  document.getElementById('radio' + counter).checked = true;
  counter++;
  if (counter > 3) {
    counter = 1;
  }
}, 4000);


//get data from api in career section
    const developerCriteriaList = document.getElementById('developerCriteriaList');

    const apiUrl = 'http://localhost:8080/jobs/list';
    async function fetchData() {
        try {
            const response = await fetch(apiUrl);
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            const jsonData = await response.json();
            return jsonData;
        } catch (error) {
            console.error('Error fetching data:', error);
            return [];
        }
    }

    (async function() {
        const jsonData = await fetchData();

        jsonData.forEach(criteria => {
            const listItem = document.createElement('li');
            listItem.className = 'course-card';

            const figure = document.createElement('figure');
            figure.className = 'card-banner img-holder';
            figure.style.setProperty('--width', '150');
            figure.style.setProperty('--height', '100');
          
            const img = document.createElement('img');
            img.src = criteria.jobImageLink;
            img.width = 150;
            img.height = 100;
            img.loading = 'lazy';
            img.alt = "Job Image";
            img.className = 'img-cover';
          
            figure.appendChild(img);
            listItem.appendChild(figure);
          
            const cardContent = document.createElement('div');
            cardContent.className = 'card-content';
          
            const badge = document.createElement('span');
            badge.className = 'badge';
            badge.textContent = criteria.jobTitle;
          
            const title = document.createElement('h3');
            title.className = 'h3';
            title.textContent = criteria.jobTitle;
          
            const educationParagraph = document.createElement('p');
            educationParagraph.textContent = `Description: ${criteria.jobDesc}`;
          
            // ... Append other content ...
          
            cardContent.appendChild(badge);
            cardContent.appendChild(title);
            cardContent.appendChild(educationParagraph);
            // ... Append other content ...
          
            listItem.appendChild(cardContent);
          
            const buttonWrapper = document.createElement('div');
            buttonWrapper.className = 'wrapper';
          
            const applyButton = document.createElement('button');
            applyButton.type = 'button';
            applyButton.className = 'btn btn-dark btn-sm myForm';
          
            const applyLink = document.createElement('a');
            applyLink.href = `Application.html?id=${criteria.jobId}`;
            applyLink.textContent = 'Apply Now';
            applyButton.appendChild(applyLink);
          
            buttonWrapper.appendChild(applyButton);
            listItem.appendChild(buttonWrapper);          
            developerCriteriaList.appendChild(listItem);
        });
    })();




//geting data by array
// const developerCriteriaList = document.getElementById('developerCriteriaList');

// const jsonData =
//   [
//     {
//       "jobId": 1,
//       "jobTitle": "Software Engineer",
//       "jobDescription": "We are looking for a skilled Software Engineer to join our development team...",
//       "numberOfRequirements": 5,
//       "jobQualification": "Bachelor's degree in Computer Science or related field",
//       "minimumExperience": "2 years of relevant experience",
//       "salaryRange": "60,000 - 80,000",
//       "jobPostedDate": 1692037800000,
//       "jobImage": "humare raipur",
//       "jobImageLink": "./assets/images/1.jpg"
//     },
//     {
//       "jobId": 2,
//       "jobTitle": "Web developer",
//       "jobDescription": "Develop and maintain software applications",
//       "numberOfRequirements": 3,
//       "jobQualification": "Bachelor's degree in Computer Science",
//       "minimumExperience": "2 years",
//       "salaryRange": "$70,000 - $90,000",
//       "jobPostedDate": 1692556200000,
//       "jobImage": "Jai chhattisgarh",
//       "jobImageLink": " ./assets/images/2.jpg"
//     },
//     {
//       "jobId": 3,
//       "jobTitle": "iOS developer",
//       "jobDescription": "Develop and maintain software applications",
//       "numberOfRequirements": 3,
//       "jobQualification": "Bachelor's degree in Computer Science",
//       "minimumExperience": "2 years",
//       "salaryRange": "$70,000 - $90,000",
//       "jobPostedDate": '02/10/2023',
//       "jobImage": "Jai Hind",
//       "jobImageLink": " ./assets/images/3.jpg"
//     },
//     {
//       "jobId": 4,
//       "jobTitle": "Software",
//       "jobDescription": "Develop and maintain software applications",
//       "numberOfRequirements": 3,
//       "jobQualification": "Bachelor's degree in Computer Science",
//       "minimumExperience": "2 years",
//       "salaryRange": "$70,000 - $90,000",
//       "jobPostedDate": 1692556200000,
//       "jobImage": "World",
//       "jobImageLink": " ./assets/images/4.jpg"
//     },
//     {
//       "jobId": 5,
//       "jobTitle": "Backend",
//       "jobDescription": "Develop and maintain software applications",
//       "numberOfRequirements": 3,
//       "jobQualification": "Bachelor's degree in Computer Science",
//       "minimumExperience": "2 years",
//       "salaryRange": "$70,000 - $90,000",
//       "jobPostedDate": 1692556200000,
//       "jobImage": "hello",
//       "jobImageLink": "./assets/images/1.jpg"
//     }
//   ];

// jsonData.forEach(criteria => {
//   const listItem = document.createElement('li');
//   listItem.className = 'course-card';

//   const figure = document.createElement('figure');
//   figure.className = 'card-banner img-holder';
//   figure.style.setProperty('--width', '150');
//   figure.style.setProperty('--height', '100');

//   const img = document.createElement('img');
//   img.src = criteria.jobImageLink || './assets/images/default-image.jpg';
//   img.width = 150;
//   img.height = 100;
//   img.loading = 'lazy';
//   img.alt = "Job Image";
//   img.className = 'img-cover';

//   figure.appendChild(img);
//   listItem.appendChild(figure);

//   const cardContent = document.createElement('div');
//   cardContent.className = 'card-content';

//   const badge = document.createElement('span');
//   badge.className = 'badge';
//   badge.textContent = criteria.jobTitle;

//   const title = document.createElement('h3');
//   title.className = 'h3';
//   title.textContent = criteria.jobTitle;

//   const educationParagraph = document.createElement('p');
//   educationParagraph.textContent = `Description: ${criteria.jobDescription}`;

//   // ... Append other content ...

//   cardContent.appendChild(badge);
//   cardContent.appendChild(title);
//   cardContent.appendChild(educationParagraph);
//   // ... Append other content ...

//   listItem.appendChild(cardContent);

//   const buttonWrapper = document.createElement('div');
//   buttonWrapper.className = 'wrapper';

//   const applyButton = document.createElement('button');
//   applyButton.type = 'button';
//   applyButton.className = 'btn btn-dark btn-sm myForm';

//   const applyLink = document.createElement('a');
//   applyLink.href = `Application.html?id=${criteria.jobId}`;
//   applyLink.textContent = 'Apply Now';
//   applyButton.appendChild(applyLink);

//   buttonWrapper.appendChild(applyButton);
//   listItem.appendChild(buttonWrapper);

//   developerCriteriaList.appendChild(listItem);
// });