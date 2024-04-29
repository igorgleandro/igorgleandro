function render(data) {
  const container = document.querySelector('#container');
  const newDiv = document.querySelector('#newDiv');
  container.innerHTML = '';
  

  //button drinks
  function renderImage2(imageUrl) {
    const imageContainer2 = document.createElement('div');
    imageContainer2.classList.add('image-container2');
  
    const imageElement2 = document.createElement('img');
    imageElement2.id = 'drinkImage';
    imageElement2.src = imageUrl;
  
    imageContainer2.appendChild(imageElement2);
    container.appendChild(imageContainer2);
  }

  renderImage2('img/martini.png');




  //import Social Media
  // Create a script element
  const script = document.createElement('script');
  // Set the source URL
  script.src = 'https://static.addtoany.com/menu/page.js';
  // Set the async attribute to load the script asynchronously
  script.async = true;
  // Append the script element to the document's head
  document.head.appendChild(script);
  // Polaroid Card
  const polaroidCard = document.createElement('div');
  polaroidCard.innerHTML = ` 
  <div class="card-container">
  <div class="flip-card">
  <div class="flip-card-inner">
  <div class="flip-card-front">
  <div>
  <p></p>
  <p id="cardType">${data.type}</p>
  <img id="barImage" src=${data.imgLink} alt="Avatar"/>
  </div>
  
  <h3 id="cardName">${data.name}</h3>
  
  <p id ="cardAdress">${data.address} - ${data.city}</p>
  
  </div>
  <div class="flip-card-back">
  <p></p>
  <p>${data.type}</p>
  <h2></h2> 
  <p style="font-size: small;"></p>
  <iframe id="map" src="${data.embeddedMap}" width="90%" height="70%" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
  <p id="girls">Invite your Girls!</p>
  <p class="centered-buttons">
  <br>

<div class="a2a_kit a2a_kit_size_32 a2a_default_style" id="shareButtons">
<a class="a2a_dd" href="https://www.addtoany.com/share"></a>
<a class="a2a_button_facebook"></a>
<a class="a2a_button_whatsapp"></a>
<a class="a2a_button_x"></a>
</div>

</div>
</p>
  </div>
  
  </div>

  </div>
  </div>`;

  // Adicionar script e div ao contêiner
  container.appendChild(polaroidCard);
  renderImage('img/home.png');
  buttonActions();
  window.a2a.init();
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

  const button1 = document.querySelector('.image-container2');
  button1.addEventListener('click', function (event) {
    event.preventDefault();
    window.location.hash = '/drink';
  });
}
export default { render };
