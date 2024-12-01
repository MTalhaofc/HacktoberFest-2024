const questions = document.querySelectorAll(".question");
questions.forEach(function (question){
    let btn = question.querySelector(".question-btn");
    question.classList.remove("show-ans");
    btn.addEventListener("click",function(){
        question.classList.toggle("show-ans");
    })
});
