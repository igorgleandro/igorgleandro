

async function fetchCharacters() {

  const api = 'https://hp-api.onrender.com/api/characters';
  const response = await fetch(api);
  
  const data = await response.json();
  const hpCharacters = data;
  
  return hpCharacters;
}

const hpCharacters = fetchCharacters()


async function getHpCharacter(index) {
  return await hpCharacters[index]
};

async function getHpCharacters() {
  return await hpCharacters;
}

export default { getHpCharacter, getHpCharacters };



