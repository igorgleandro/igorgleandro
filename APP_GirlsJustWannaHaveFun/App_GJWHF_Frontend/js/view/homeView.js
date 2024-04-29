import * as THREE from 'https://cdn.skypack.dev/three@0.129.0/build/three.module.js';
import { GLTFLoader } from 'https://cdn.skypack.dev/three@0.129.0/examples/jsm/loaders/GLTFLoader.js';

const container = document.getElementById('container');
const newDiv = document.getElementById('newDiv');
let audioEnabled = false;

// Array de cores
const colors = [
  new THREE.Color("pink"),   
  new THREE.Color("purple"), 
  new THREE.Color("blue"),  
  new THREE.Color("red")     
];

function render(data) {
  showView(data);
  // Verifica se o áudio está desativado e o ativa se necessário
  if (!audioEnabled) {
    audio();
  }
  animateHome();
  addBigLetter();
}

function addBigLetter() {
  // Crie um novo elemento div para a letra grande
  const bigLetterDiv = document.createElement('div');
  bigLetterDiv.classList.add('big-letter');
  bigLetterDiv.textContent = 'Girls just wanna have fun'; // Adicione a letra que deseja exibir
  
  // Adicione a letra grande ao corpo do documento
  container.appendChild(bigLetterDiv);
}

function audio() {
  const audioElement = document.createElement('audio');
  audioElement.src = 'audio/music.mp3';
  audioElement.autoplay = true;
  document.body.appendChild(audioElement);

  audioEnabled = true; // Atualiza a variável para indicar que o áudio foi ativado
}

function showView(data) {
  container.innerHTML = '';
  newDiv.innerHTML = '';

  // AUDIO

  // Crie um novo elemento div para o buttonBox
  const buttonBox = document.createElement('div');
  buttonBox.id = 'buttonBox';

  // Crie um novo elemento button
  const button = document.createElement('button');
  button.id = 'button';
  button.textContent = 'Get Started';

  // Adicione o botão ao buttonBox
  buttonBox.appendChild(button);

  // Adicione o buttonBox ao container
  container.appendChild(buttonBox);

  // Adicione o evento de clique ao botão
  button.addEventListener('click', function (event) {
    event.preventDefault();
    console.log('clicked');
    window.location.hash = '/quiz';
    // Se você estiver usando o window.location.hash para navegação, certifique-se de que a lógica está correta.
    // window.location.hash = '/quiz';
  });
}

function animateHome () {
  const scene = new THREE.Scene();
  const camera = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000);
  const renderer = new THREE.WebGLRenderer({ alpha: true });
  renderer.setSize(window.innerWidth, 750)
  document.getElementById("newDiv").appendChild(renderer.domElement);
  
  const loader = new GLTFLoader();
  let object;
  let modelRadius; 
  
  loader.load(
    `models/eye/scene.gltf`,
    function (gltf) {
      object = gltf.scene;
  
      const bbox = new THREE.Box3().setFromObject(object);
      const sphere = new THREE.Sphere();
      bbox.getBoundingSphere(sphere);
      modelRadius = sphere.radius;
  
      const scale = 2.5; 
      object.scale.set(scale, scale, scale);
  
      scene.add(object);
      object.position.set(0, 1.8, 0); 
    },
    function (xhr) {
      console.log((xhr.loaded / xhr.total * 100) + '% loaded');
    },
    function (error) {
      console.error(error);
    }
  );
  
  const directionalLight = new THREE.DirectionalLight(0xffffff, 1);
  directionalLight.position.set(200, -10, 10);
  scene.add(directionalLight);
  
  const ambientLight = new THREE.AmbientLight(0xffffff, 100); 
  scene.add(ambientLight);
  
  camera.position.z = 5;
  
  let hue = 0;
  let targetColor = colors[0]; // Inicializa com a primeira cor do array
  const transitionSpeed = 0.01;
  
  function animate() {
    requestAnimationFrame(animate);
  
    if (object) {
      object.rotation.y += 0.02; // Rotação contínua
    }
  
    ambientLight.color.lerp(targetColor, transitionSpeed);
  
    renderer.render(scene, camera);
  }
  
  window.addEventListener("resize", function () {
    camera.aspect = window.innerWidth / window.innerHeight;
    camera.updateProjectionMatrix();
    renderer.setSize(window.innerWidth, window.innerHeight);
  });
  
  animate();
  
  function setRandomColor() {
    const currentIndex = colors.indexOf(targetColor);
    const nextIndex = (currentIndex + 1) % colors.length;
    targetColor = colors[nextIndex];
  }
  
  setInterval(setRandomColor, 2000); 
}  

export default { render };
