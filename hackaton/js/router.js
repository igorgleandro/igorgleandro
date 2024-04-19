import routes from '/js/routes.js';

async function launchController(controllerName) {
  try {
    const module = await import(`/js/controller/${controllerName}.js`);
    module.default.init();
  } catch (err) {
    console.error(err);
  }
}

function setCurrentRoute({ path, controller }) {
  routes.currentPath.path = path;
  routes.currentPath.controller = controller;
}

function navigate(path) {
  if (path === routes.currentPath.path) {
    return;
  }

  const routesKey = Object.keys(routes).find(
    (key) => routes[key].path === path
  );

  let route = routes[routesKey];

  if (!route) {
    route = routes.home;
    window.location.hash = routes.home.path;
  }

  setCurrentRoute(route);
  launchController(route.controller);
}

function getPath(urlStr) {
  return new URL(urlStr).hash.slice(1);
}

function init() {
  window.location.hash = window.location.hash || routes.home.path;

  navigate(getPath(window.location.href));

  window.addEventListener('hashchange', function (event) {
    const path = getPath(event.newURL);
    navigate(path);
  });
}

export default { init };
