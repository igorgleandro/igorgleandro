let currentQuestionIndex = 0;
let totalQuestions = 0;
let questionsData = null;
let questionsAnswered = 0;

function render(data) {
  questionsData = data;
  totalQuestions = data.results.length;
  questionsAnswered = 0;
  showQuestion(data, currentQuestionIndex);
}

function showQuestion(data, questionIndex) {
  const container = document.querySelector('#container');
  container.innerHTML = '';

  const question = data.results[questionIndex];

  const answers = question.incorrect_answers.concat(question.correct_answer);

  shuffleArray(answers);

  const questionDiv = document.createElement('div');
  questionDiv.classList.add('d-grid', 'gap-2');

  questionDiv.innerHTML = `
    <div class="question-header" id="counter">
      <p>Question ${questionIndex + 1}/${totalQuestions}</p>
    </div>
    <button id="question1" class="btn btn-primary question" type="button">${
      question.question
    }</button>`;

  const optionsDiv = document.createElement('div');
  optionsDiv.classList.add('d-grid', 'gap-2');
  answers.forEach((answer) => {
    optionsDiv.innerHTML += `<div id="answer2" class="btn btn-secondary option">${answer}</div>`;
  });

  container.appendChild(questionDiv);
  container.appendChild(optionsDiv);

  const options = document.querySelectorAll('.option');
  options.forEach((option) => {
    option.addEventListener('click', () => {
      const selectedAnswer = option.textContent;
      if (selectedAnswer === question.correct_answer) {
        showResult('Correct');
      } else {
        showResult('Wrong');
      }
      questionsAnswered++;
      if (questionsAnswered === totalQuestions) {
        showResult('Quiz Finished');
      }
    });
  });
}

function showResult(resultText) {
  const resultDiv = document.querySelector('#result');
  resultDiv.textContent = resultText;

  if (resultText === 'Correct') {
    resultDiv.classList.add('correct');
  } else if (resultText === 'Wrong' || resultText === 'Quiz Finished') {
    resultDiv.classList.add('wrong');
  }

  resultDiv.style.display = 'block';

  if (resultText === 'Quiz Finished') {
    const startNewQuizButton = document.createElement('button');
    startNewQuizButton.textContent = 'Start New Quiz';
    startNewQuizButton.addEventListener('click', (e) => {
      e.preventDefault();
      window.location.hash = '/';
      resultDiv.style.display = 'none';
      currentQuestionIndex = 0;
      questionsAnswered = 0;
      document.querySelector('#container').innerHTML = '';
    });
    resultDiv.appendChild(startNewQuizButton);
  } else {
    const nextButton = document.createElement('button');
    nextButton.textContent = 'Next Question';
    nextButton.addEventListener('click', (e) => {
      e.preventDefault();
      currentQuestionIndex++;
      if (currentQuestionIndex < totalQuestions) {
        showQuestion(questionsData, currentQuestionIndex);
        resultDiv.style.display = 'none';
      }
    });
    resultDiv.appendChild(nextButton);
  }
}

// SHUFFLE ARRAY

function shuffleArray(array) {
  for (let i = array.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [array[i], array[j]] = [array[j], array[i]];
  }
}

export default { render };
