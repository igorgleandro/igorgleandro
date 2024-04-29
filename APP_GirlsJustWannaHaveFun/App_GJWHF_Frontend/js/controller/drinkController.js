import drinkView from '/js/view/drinkView.js';
import drinkService from '/js/service/drinkService.js';


async function init() {
    const result = await drinkService.getQuestions();
    drinkView.render(result);
}
export default {init};