import spellsService from '/js/service/spellsService.js';
import spellsView from '/js/view/spellsView.js';

async function init() {
  const hpSpells = await spellsService.getHpSpells();
  spellsView.render(hpSpells);
};

export default { init };
