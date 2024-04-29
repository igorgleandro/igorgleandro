import drinkController from '/js/controller/drinkController.js';

const newDiv = document.querySelector('#newDiv');
function render(data) {
  const container = document.querySelector('#container');
  container.innerHTML = '';
  newDiv.innerHTML = '';
  const newData = [];

  //button repeat
  function renderImage2(imageUrl) {
    const imageContainer2 = document.createElement('div');
    imageContainer2.classList.add('image-container3');

    const imageElement2 = document.createElement('img');
    imageElement2.id = 'drinkImage';
    imageElement2.src = imageUrl;

    imageContainer2.appendChild(imageElement2);
    container.appendChild(imageContainer2);
  }




  renderImage2('img/rewind-button.png');

  let arr = [
    data.drinks[0].strIngredient1,
    data.drinks[0].strIngredient2,
    data.drinks[0].strIngredient3,
    data.drinks[0].strIngredient4,
    data.drinks[0].strIngredient5,
    data.drinks[0].strIngredient6,
    data.drinks[0].strIngredient7,
    data.drinks[0].strIngredient8,
    data.drinks[0].strIngredient9,
    data.drinks[0].strIngredient10,
  ];

  let str = changeArrey(arr);
  // Polaroid Card
  const polaroidCard = document.createElement('div');
  polaroidCard.innerHTML = ` 
      <div class="card-container2">
      <div class="flip-card2">
      <div class="flip-card-inner2">
      <div class="flip-card-front2">
      <div>
      <p></p>
      <p>${data.drinks[0].strCategory}</p>
      <img id="drinkCardImage" src=${data.drinks[0].strDrinkThumb} alt="Avatar"/> 
      </div>
      <h2 id="drinkName">${data.drinks[0].strDrink}</h2>
      
      <p id="drinkAdress">${data.drinks[0].strAlcoholic}</p>
      
      </div>
      <div class="flip-card-back2">
      <p></p>
      <h2 id="drinkBio">${data.drinks[0].strDrink}</h2>
      <h2></h2> 
      <p id="drinkDescript"style="font-size: small;"></p>
      ${str}
      </div>
      </div>
      </div>
      </div>`;

  container.appendChild(polaroidCard);
  renderImage('img/home.png');
  buttonActions();
}

function renderImage(imageUrl) {
  const imageContainer = document.createElement('div');
  imageContainer.classList.add('image-container');

  const imageElement = document.createElement('img');
  imageElement.src = imageUrl;

  imageContainer.appendChild(imageElement);
  container.appendChild(imageContainer);
}

function buttonActions(data) {
  const button = document.querySelector('.image-container');
  button.addEventListener('click', function (event) {
    event.preventDefault();
    window.location.hash = '/';
  });
  const button1 = document.querySelector('.image-container3');
  button1.addEventListener('click', function (event) {
    event.preventDefault();
    drinkController.init();
  });

}

function changeArrey(arr) {
  let str = '';
  arr.forEach((element) => {
    if (element === null) {
      return str;
    }
    str += '<p>' + element + '</p>';
  });
  return str;
}

function previousData (data) {
  newData = data;
}

export default { render, previousData};
