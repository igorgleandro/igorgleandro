import quizView from '/js/view/quizView.js';
import quizService from '/js/service/quizService.js';

let questions = [];

async function init() {
    questions = await quizService.getQuestions();
    quizView.render(questions);
}
export default {init};