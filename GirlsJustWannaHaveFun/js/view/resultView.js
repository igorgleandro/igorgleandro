const newDiv = document.querySelector('#newDiv');
function render(data) {
  const container = document.querySelector('#container');
  
  container.innerHTML = '';

  const data2 = {
    name: 'Castle Rock Pub & Hotel',
    address: 'R. do Conde de Vizela 114',
    type: 'BAR',
    city: 'PORTO',
    genre: 'ROCK',
    imgLink:
      'https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Harry_Potter_Platform_Kings_Cross.jpg/2560px-Harry_Potter_Platform_Kings_Cross.jpg',
    embeddedMap:
      'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d48068.863369866776!2d-8.635973932564996!3d41.149718290103415!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd2465001381b561%3A0x72efb599ac56f918!2sCode%20for%20All%20-%20OportoUnity!5e0!3m2!1sen!2spt!4v1713393973231!5m2!1sen!2spt',
    description: '',
  };

  // Polaroid Card
  const polaroidCard = document.createElement('div');
  polaroidCard.innerHTML = ` 
    <div class="card-container">
    <div class="flip-card">
    <div class="flip-card-inner">
    <div class="flip-card-front">
    <div>
    <p></p>
    <p>${data.type}</p>
    <img src=${data.imgLink} alt="Avatar" style="border-radius: 5%;
    width: 250px;
    height: 300px;
    margin-bottom: 4%;    
    overflow: hidden;
    position: relative;"> 
    </div>
    <h2>${data.name}</h2>
    
    <p>${data.address} - ${data.city}</p>
    
    </div>
    <div class="flip-card-back">
    <p></p>
    <p>${data.type}</p>
    <h2></h2> 
    <p style="font-size: small;"></p>
    <iframe src="${data.embeddedMap}" width="250" height="300" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
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
  newDiv.appendChild(imageContainer);
}

function buttonActions(data) {
  const button = document.querySelector('.image-container');
  button.addEventListener('click', function (event) {
    event.preventDefault();
    window.location.hash = '/';
  });
  const button1 = document.createElement('img');
  button1.src = 'img/martini.png';
  button1.addEventListener('click', function (event) {
    event.preventDefault();
    window.location.hash = '/drink';
  }); 
  
  newDiv.appendChild(button1);
}

export default { render };
