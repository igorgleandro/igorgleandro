import homeView from '/js/view/homeView.js';
import homeService from '/js/service/homeService.js';

async function init() {
  const data = await homeService.getCategories();
  homeView.render(data);
};

export default { init };
