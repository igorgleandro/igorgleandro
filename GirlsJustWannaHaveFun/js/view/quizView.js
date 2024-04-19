let currentQuestionIndex = 0;
let type = 'notype';
let city = 'nocity';
let genre = 'nogenre';
const container = document.getElementById('container');

function render(data) {
  showQuestion(data, currentQuestionIndex);
  renderImage('img/home.png');
  renderBackward('img/backward.png', data);
  buttonActions(data);
}

async function showQuestion(data, index) {
  const container = document.querySelector('#container');
  const newDiv = document.querySelector('#newDiv');
  container.innerHTML = '';
  newDiv.innerHTML = '';

  // question header
  const questionDiv = document.createElement('div');
  questionDiv.classList.add('question-header');
  questionDiv.textContent = data[index].question;
  container.appendChild(questionDiv);

  // answer container
  const answersDiv = document.createElement('div');
  answersDiv.classList.add('question-container');
  // each awnser
  data[index].answers.forEach((answer) => {
    const answerDiv = document.createElement('div');
    answerDiv.classList.add('answer');
    answerDiv.textContent = answer;
    answersDiv.appendChild(answerDiv);
  });

  // footer
  const witchyWarning = document.createElement('div');
  witchyWarning.innerHTML = `
    <div id="menu">
    </div>
  `;

  container.appendChild(answersDiv);
  container.appendChild(witchyWarning);
}

function renderImage(imageUrl) {
  const imageContainer = document.createElement('div');
  imageContainer.classList.add('image-container');

  const imageElement = document.createElement('img');
  imageElement.src = imageUrl;

  imageContainer.appendChild(imageElement);
  container.appendChild(imageContainer);
}

function renderBackward(imageUrl, data) {
  const backwardButton = document.createElement('img');
  backwardButton.src = imageUrl;
  backwardButton.classList.add('backward');

  backwardButton.addEventListener('click', function (event) {
    event.preventDefault();
    if (currentQuestionIndex > 0) {
      currentQuestionIndex--; // Decrement only if currentQuestionIndex is greater than 0
      render(data);
    } else {
      currentQuestionIndex = 0;
      window.location.hash = '/';
      return;
    }
  });

  newDiv.appendChild(backwardButton);
}

function buttonActions(data) {
  const button = document.querySelector('.image-container');
  button.addEventListener('click', function (event) {
    event.preventDefault();
    window.location.hash = '/';
  });

  const options = document.querySelectorAll('.answer');

  options.forEach((option) => {
    option.addEventListener('click', () => {
      if (currentQuestionIndex === 1) {
        type = option.textContent;
      }
      if (currentQuestionIndex === 2) {
        //city = option.textContent;
      }
      if (currentQuestionIndex === 3) {
        //genre = option.textContent;
      }
      if (currentQuestionIndex === 5) {
        window.location.hash = '/result';
        currentQuestionIndex = 0;
        return;
      }
      currentQuestionIndex++;
      render(data);
    });
  });
}
function returnType() {
  return type;
}

function returnCity() {
  return city;
}

function returnGenre() {
  return genre;
}

export default { render, returnType, returnCity, returnGenre };
