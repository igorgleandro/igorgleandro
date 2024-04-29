import quizView from '/js/view/quizView.js';
import quizService from '/js/service/quizService.js';

async function init() {
    const data = await quizService.getQuestions();
    quizView.render(data);
  };
  
  export default { init };
  