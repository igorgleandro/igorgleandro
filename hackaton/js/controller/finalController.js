import finalView from '/js/view/finalView.js';
import finalService from `/js/view/finalService.js`;

async function init() {
  const data = await finalService.getClubDatas();
  finalView.render(data);
};

export default { init };