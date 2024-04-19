import quizView from '/js/view/quizView.js';

async function getQuestions() {
  const returnType = quizView.returnType();
  const returnCity = quizView.returnCity();
  const returnGenre = quizView.returnGenre();
  console.log(returnType);
  console.log(returnCity);
  console.log(returnGenre);

  const api = `http://localhost:8080/girlshavingfun/api/${returnType}/${returnCity}/${returnGenre}/`;

  try {
    const response = await fetch(api);
    const data = await response.json();
    return data;
  } catch (error) {
    console.error(error);
  }
}

export default { getQuestions };

