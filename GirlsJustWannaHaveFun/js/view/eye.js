import * as THREE from "https://cdn.skypack.dev/three@0.129.0/build/three.module.js";
import { OrbitControls } from "https://cdn.skypack.dev/three@0.129.0/examples/jsm/controls/OrbitControls.js";
import { GLTFLoader } from "https://cdn.skypack.dev/three@0.129.0/examples/jsm/loaders/GLTFLoader.js";

function animateHome () {

const scene = new THREE.Scene();
const camera = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000);
const renderer = new THREE.WebGLRenderer({ alpha: true });
renderer.setSize(window.innerWidth, window.innerHeight);
document.getElementById("buttonBox").appendChild(renderer.domElement);

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

   
        const scale = 2; 
        object.scale.set(scale, scale, scale);

        scene.add(object);
        object.position.set(0, 2.11, 0); 
    },
    function (xhr) {
        console.log((xhr.loaded / xhr.total * 100) + '% loaded');
    },
    function (error) {
        console.error(error);
    }
);


const directionalLight = new THREE.DirectionalLight(0xffffff, 1);
directionalLight.position.set(200, 10, 10);
scene.add(directionalLight);

const ambientLight = new THREE.AmbientLight(0xffffff, 100); 
scene.add(ambientLight);

camera.position.z = 5;

const controls = new OrbitControls(camera, renderer.domElement);

let hue = 0;
let targetColor = new THREE.Color(); 
const transitionSpeed = 0.01;

function animate() {
    requestAnimationFrame(animate);

    if (object) {
        object.rotation.y += 0.01;
    }

    ambientLight.color.lerp(targetColor, transitionSpeed);

    controls.update();

    renderer.render(scene, camera);
}

window.addEventListener("resize", function () {
    camera.aspect = window.innerWidth / window.innerHeight;
    camera.updateProjectionMatrix();
    renderer.setSize(window.innerWidth, window.innerHeight);
});

animate();

function setRandomColor() {
    const colors = [
        new THREE.Color("pink"),   
        new THREE.Color("purple"), 
        new THREE.Color("blue"),  
        new THREE.Color("red")     
    ];
    targetColor = colors[Math.floor(Math.random() * colors.length)];
}

setInterval(setRandomColor, 2000); 
}

export { animateHome }
