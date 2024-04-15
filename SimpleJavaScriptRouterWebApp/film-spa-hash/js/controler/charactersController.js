import charactersService from '/js/service/charactersService.js';
import charactersView from '/js/view/charactersView.js';

async function init() {
  const hpCharacters = await charactersService.getHpCharacters();
  charactersView.render(hpCharacters);
};

export default { init };