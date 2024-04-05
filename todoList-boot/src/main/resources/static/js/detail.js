// 목록으로 버튼 동작
const goToList = document.querySelector("#goToList");

goToList.addEventListener("click", () => {

    location.href = "/"; //메인페이지로 요청

});

//완료 여부 변경 버튼 동작
const completeBtn = document.querySelector(".complete-btn")

completeBtn.addEventListener("click", (e) => {


    const todoNo = e.target.dataset.todoNo;

    //console.log(todoNo);

    // Y <-> N 변경

    let complete = e.target.innerText; //기존 완료 여부 값 얻어오기

    complete = (complete === 'Y') ? 'N' : 'Y' ;
    // === : 완전 엄격하게 따짐, 타입까지 같은지 확인

    //완료 여부 수정 요청하기
    location.href
        = `/todo/changeComplete?todoNo=${todoNo}&complete=${complete}`;  //~ 표시 그냥 누르면 나옴 ``(백틱)

});

//-------------------------------------------------------

//수정 버튼 클릭 시
const updateBtn = document.querySelector("#updateBtn");

updateBtn.addEventListener("click", e => {

    //data-todo-no 얻어오기
    const todoNo = e.target.dataset.todoNo;

    location.href = `/todo/update?todoNo=${todoNo}`;
});

//console 창에서 error 확인하기


//--------------------------------------------------------

//삭제 버튼 클릭 시
const deleteBtn = document.querySelector("#deleteBtn");

deleteBtn.addEventListener("click", e => {

        if(confirm("삭제 하시겠습니까?")){
            location.href = `/todo/delete?todoNo=${e.target.dataset.todoNo}`;
        }
});










