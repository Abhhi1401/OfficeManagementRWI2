'use strict';




// document.addEventListener("DOMContentLoaded", function() {
//   const slider = document.querySelector(".slider");
//   const slides = slider.querySelectorAll("img");
//   // const slideWidth = slides[0].clientWidth;
//   let currentSlide = 0;

//   function showSlide(slideIndex) {
//     if (slideIndex < 0) {
//       slideIndex = slides.length + 1;
//     } else if (slideIndex >= slides.length) {
//       slideIndex = 0;
//     }

//     slides.forEach((slide, index) => {
//       if (index === slideIndex) {
//         slide.style.left = "0";
//       } else {
//         slide.style.left = "100%";
//       }
//     });

//     // slides.forEach((slide, index) => {
//     //   const distance = (index - slideIndex) * slideWidth;
//     //   slide.style.transform = `translateX(${distance}px)`;
//     // });


//     currentSlide = slideIndex;
//   }

//   function nextSlide() {
//     showSlide(currentSlide + 1);
//   }

//   function previousSlide() {
//     showSlide(currentSlide - 1);
//   }

//   setInterval(nextSlide, 2000); // Change slide every 3 seconds (adjust as needed)
//  });


/* JavaScript for the image slider */










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


//  fetch data from api in index page - #careers
async function fetchData(apiUrl) {
  try {
    const response = await fetch(apiUrl);
    if (!response.ok) {
      throw new Error("Network response was not ok.");
    }
    return response.json();
  } catch (error) {
    console.error("Error fetching data:", error);
  }
}

// Function to create the course card
function createCourseCard(course) {
  const listItem = document.createElement("li");

  const courseCardDiv = document.createElement("div");
  courseCardDiv.className = "course-card";

  const figure = document.createElement("figure");
  figure.className = "card-banner img-holder";
  figure.style = "--width: 370px; --height: 220px;";

  const image = document.createElement("img");
  image.src = course.image;
  image.width = 370;
  image.height = 220;
  image.loading = "lazy";
  image.alt = course.title;
  image.className = "img-cover";
  figure.appendChild(image);

  const cardContentDiv = document.createElement("div");
  cardContentDiv.className = "card-content";

  const badgeSpan = document.createElement("span");
  badgeSpan.className = "badge";
  badgeSpan.textContent = course.category;

  const heading = document.createElement("h3");
  heading.className = "h3 mt-1 wrapper";
  heading.textContent = course.title;

  const ratingWrapperDiv = document.createElement("div");
  ratingWrapperDiv.className = "wrapper";
  for (let i = 0; i < 5; i++) {
    const starIcon = document.createElement("ion-icon");
    starIcon.name = "star";
    ratingWrapperDiv.appendChild(starIcon);
  }

  const buttonWrapperDiv = document.createElement("div");
  buttonWrapperDiv.className = "wrapper";

  const applyButton = document.createElement("button");
  applyButton.type = "button";
  applyButton.className = "btn btn-dark .btn-sm";

  const applyLink = document.createElement("a");
  applyLink.href = course.applicationLink;
  applyLink.textContent = "Apply Now";
  applyButton.appendChild(applyLink);

  buttonWrapperDiv.appendChild(applyButton);

  cardContentDiv.appendChild(badgeSpan);
  cardContentDiv.appendChild(heading);
  cardContentDiv.appendChild(ratingWrapperDiv);
  cardContentDiv.appendChild(buttonWrapperDiv);

  courseCardDiv.appendChild(figure);
  courseCardDiv.appendChild(cardContentDiv);

  listItem.appendChild(courseCardDiv);

  return listItem;
}

async function populateCourses(apiUrl) {
  const gridList = document.querySelector(".grid-list");
  const courses = await fetchData(apiUrl);

  courses.forEach(course => {
    const courseCard = createCourseCard(course);
    gridList.appendChild(courseCard);
  });
}

const apiUrl = "http://localhost:8080/jobs/list";

populateCourses(apiUrl);


