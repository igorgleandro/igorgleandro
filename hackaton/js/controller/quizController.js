import quizView from '/js/view/quizView.js';
import quizService from '/js/service/quizService.js';

async function init() {
  const questions = await quizService.getQuestions();
  const firstQuestion = questions[0];
  quizView.render(firstQuestion);
}

export default { init };
