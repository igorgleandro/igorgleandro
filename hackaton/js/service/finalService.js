
import quizView from '/js/view/quizView.js';

async function getClubData() {
  const returnType = quizView.returnType();
  const returnCity = quizView.returnCity();
  const returnGenre = quizView.returnGenre();
  console.log(returnType);
  console.log(returnCity);
  console.log(returnGenre);

  /*const api = `http://localhost:8080/girlshavingfun/api/${returnType}/${returnCity}/${returnGenre}/`; */
  const api = `http://localhost:8080/girlshavingfun/api/bar/porto/rock/`

  try {
    const response = await fetch(api);
    const clubData = await response.json();
    return clubData;
  } catch (error) {
    console.error(error);
  }
}
async function getClubData(index) {
  return clubData[index]
};

async function getClubDatas() {
  return clubData;
}

export default { getClubData,getClubDatas };
  