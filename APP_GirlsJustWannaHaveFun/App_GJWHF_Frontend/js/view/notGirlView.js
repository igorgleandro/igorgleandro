import quizView from '/js/view/quizView.js';

const container = document.getElementById('container');

function render(data) {
  showView();
  addBigLetter();
  renderImage('img/home.png');
  buttonActions();
}

function showView() {
  container.innerHTML = '';
}

function addBigLetter() {
  // Crie um novo elemento div para a letra grande
  const bigLetterDiv = document.createElement('div');
  const justGirls = document.createElement('div');
  justGirls.classList.add('justGirls');
  bigLetterDiv.classList.add('four');
  bigLetterDiv.textContent = '404'; // Adicione a letra que deseja exibir
  justGirls.textContent = 'This app is only for Girls!';

  // Adicione a letra grande ao corpo do documento
  container.appendChild(bigLetterDiv);
  bigLetterDiv.appendChild(justGirls);
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
    quizView.setIndex(0);
    window.location.hash = '/';
  });
}

export default { render };
