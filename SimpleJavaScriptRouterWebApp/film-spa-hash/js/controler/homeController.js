import homeView from '/js/view/homeView.js';
import homeService from '/js/service/homeService.js';

function init() {
  homeView.render(homeService.getHpHouse);
};

export default { init };
