import quizService from '/js/service/quizService.js';

const container = document.getElementById('container');

function render(question, currentIndex) {
  // Limpa o conteúdo anterior do container
  container.innerHTML = '';

  // Cria um elemento h2 para a pergunta
  const questionElement = document.createElement('h2');
  questionElement.textContent = question.question;
  questionElement.classList.add('question-header'); // Adiciona uma classe para estilização

  // Adiciona a pergunta ao contêiner principal
  container.appendChild(questionElement);

  // Cria um elemento div para o contêiner das respostas
  const answersContainer = document.createElement('div');
  answersContainer.classList.add('question-container'); // Adiciona uma classe para estilização

  // Itera sobre as respostas e cria elementos div para cada uma
  question.answers.forEach((answer, index) => {
    const answerElement = document.createElement('div');
    answerElement.textContent = answer;
    answerElement.classList.add('answer'); // Adiciona uma classe para estilização
    answerElement.setAttribute('data-index', index);

    // Adiciona um ouvinte de evento de clique à resposta
    answerElement.addEventListener('click', function () {
      handleAnswerSelection(index, currentIndex);
    });

    // Adiciona a resposta ao contêiner das respostas
    answersContainer.appendChild(answerElement);
  });

  // Adiciona o contêiner das respostas ao contêiner principal
  container.appendChild(answersContainer);

  const witchyWarning = document.createElement('div');
  witchyWarning.innerHTML = `
    <div id="menu">
    </div>
  `;
  container.appendChild(witchyWarning);

  // Chama a função para renderizar a imagem
  renderImage('img/home.png');
  buttonActions();
}

function handleAnswerSelection(selectedIndex, currentIndex) {
  // Obter a próxima pergunta
  const nextQuestion = quizService.getQuestion(currentIndex + 1);

  if (nextQuestion) {
    // Renderizar a próxima pergunta
    render(nextQuestion, currentIndex + 1);
  } else {
    console.log('Quiz concluído!');
    // Adicionar aqui qualquer ação que deseja executar quando o quiz estiver concluído
  }
}

function renderImage(imageUrl) {
  // Cria um elemento div para o contêiner da imagem
  const imageContainer = document.createElement('div');
  imageContainer.classList.add('image-container'); // Adicione uma classe para estilização

  // Cria um elemento de imagem
  const imageElement = document.createElement('img');
  imageElement.src = imageUrl; // Define o URL da imagem

  // Adiciona a imagem ao contêiner da imagem
  imageContainer.appendChild(imageElement);

  // Adiciona o contêiner da imagem ao contêiner principal
  container.appendChild(imageContainer);
}

function buttonActions() {
  const button = document.querySelector('.image-container');
  button.addEventListener('click', function (event) {
    event.preventDefault();
    console.log('clicked');
    window.location.hash = '/';
  });
}

export default { render };
