import drinkController from '/js/controller/drinkController.js';
const newDiv = document.querySelector("#newDiv");
function render(data) {
    const container = document.querySelector('#container');
    container.innerHTML = '';
    newDiv.innerHTML = '';

    let arr = [data.drinks[0].strIngredient1, 
    data.drinks[0].strIngredient2, data.drinks[0].strIngredient3, 
    data.drinks[0].strIngredient4, data.drinks[0].strIngredient5,
    data.drinks[0].strIngredient6, data.drinks[0].strIngredient7, 
    data.drinks[0].strIngredient8, data.drinks[0].strIngredient9,
    data.drinks[0].strIngredient10];

    let str = changeArrey(arr);
    // Polaroid Card
    const polaroidCard = document.createElement('div');
    polaroidCard.innerHTML = ` 
      <div class="card-container">
      <div class="flip-card">
      <div class="flip-card-inner">
      <div class="flip-card-front">
      <div>
      <p></p>
      <p>${data.drinks[0].strCategory}</p>
      <img src=${data.drinks[0].strDrinkThumb} alt="Avatar" style="border-radius: 5%;
      width: 250px;
      height: 300px;
      margin-bottom: 4%;    
      overflow: hidden;
      position: relative;"> 
      </div>
      <h2>${data.drinks[0].strDrink}</h2>
      
      <p>${data.drinks[0].strAlcoholic}</p>
      
      </div>
      <div class="flip-card-back">
      <p></p>
      <h2>${data.drinks[0].strDrink}</h2>
      <h2></h2> 
      <p style="font-size: small;"></p>
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
    const button1 = document.createElement("button");
    button1.addEventListener('click', function (event) {
      event.preventDefault();
      drinkController.init();
    }); 
    
    newDiv.appendChild(button1);
  }

  function changeArrey(arr){
    let str = "";
    arr.forEach(element => {
        if(element === null){
            return str;
        }
        str += "<p>" + element + "</p>";
    });
    return str;
  }
  

  export default { render };