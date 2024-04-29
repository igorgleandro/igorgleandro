import resultView from '/js/view/resultView.js';
import resultService from '/js/service/resultService.js';


async function init() {
    const result = await resultService.getQuestions();
    resultView.render(result);
}
export default {init};