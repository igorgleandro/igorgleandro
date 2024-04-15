
const hpHouses = [
  {
    "name": "Gryffindor",
    "image": "https://wallpapers.com/images/high/harry-potter-gryffindor-wallpaper-r9die8t52jn8gg7w.webp"
  },
  {
    "name": "Hufflepuff",
    "image": "https://m.media-amazon.com/images/I/81aLUsl0qeL._AC_UF894,1000_QL80_.jpg"
  },
  {
    "name": "Ravenclaw",
    "image": "https://sw6.elbenwald.de/media/49/46/7a/1629841628/E1054766_6.jpg"
  },
  {
    "name": "Slytherin",
    "image": "https://lukascondie.files.wordpress.com/2015/01/slytherin_wallpaper_by_dragonlover28-d45jhse.jpg?w=640"
  }]


async function getHpHouse(index) {
  return await hpHouses[index]
};

async function getHpHouses() {
  return await hpHouses;
}

export default { getHpHouse, getHpHouses };



