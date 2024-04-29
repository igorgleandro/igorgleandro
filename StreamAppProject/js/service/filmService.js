const axios = require('axios');

  const options = {
    method: 'GET',
    url: 'https://streaming-availability.p.rapidapi.com/search/title',
    params: {
      title: '<REQUIRED>',
      country: '<REQUIRED>',
      show_type: 'all',
      output_language: 'en'
    },
    headers: {
      'X-RapidAPI-Key': 'c2ca2274bamsh438bc73c2527518p1f1ca0jsnceba87f8a638',
      'X-RapidAPI-Host': 'streaming-availability.p.rapidapi.com'
    }
  };
  
  try {
    const films = await axios.request(options);
    console.log(films.data);
  } catch (error) {
    console.error(error);
  }



async function getFilm(index) {
  return films[index]
};

async function getFilms() {
  return films;
}

export default { getFilm, getFilms };
