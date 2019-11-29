'use strict';

/*
* Блок констант
*/
const HTTP_OK = 200;

/*
*Элементы на странице
*/
let mainCoworkersTable = document.getElementById('coworkersTable');
let mainDepartmentsTable = document.getElementById('departmentsTable');
let mainProfessionsTable = document.getElementById('professionsTable');
let departmentList = document.getElementById('inputGroupSelect01');
let professionList = document.getElementById('inputGroupSelect02');

var allItem = [];

let xhr = new XMLHttpRequest();
xhr.open('GET', '/api/v1/coworkers');
xhr.send();

xhr.onload = () => {
    if (xhr.status === HTTP_OK) {
        drawCoworkersRow(xhr.responseText)
    }
};


function drawCoworkersRow(response) {
    let items = JSON.parse(response);
    allItem = JSON.parse(response);
    items.forEach((item, index) => {
        let tr = document.createElement('tr');

        let itemId = document.createElement('td');
        let name = document.createElement('td');
        let lastname = document.createElement('td');
        let surname = document.createElement('td');
        let note = document.createElement('td');

        let professional = document.createElement('td');
        let department = document.createElement('td');
        let editPanel = document.createElement('td');
        editPanel.innerHTML = '<a href="#" onclick="goToUpdateModel(this.id)" id="element-' + item.id + '"data-toggle="modal" data-target="#exampleModal"><i class="fas fa-edit"></i></a>' + '|' + '<a href="#" id="deleteItem-' + item.id + '"  onclick="deleteItem(this.id, this.name)" name="coworkers"><i class="fas fa-user-times" ></i> </a>';


        itemId.innerText = index + 1;
        name.innerText = item.name;
        lastname.innerText = item.lastname;
        surname.innerText = item.surname;
        note.innerText = item.note;
        department.innerText = item.departmentId;
        professional.innerText = item.professionId;

        tr.appendChild(itemId);
        tr.appendChild(name);
        tr.appendChild(lastname);
        tr.appendChild(surname);
        tr.appendChild(note);
        tr.appendChild(professional);
        tr.appendChild(department);
        tr.appendChild(editPanel);
        mainCoworkersTable.appendChild(tr);
    });
}

function goToUpdateModel(id) {
    let elementId = +id.split('-')[1];
    localStorage.setItem('id', elementId);
    let item = allItem.find(value => {
        if (value.id === elementId) {
            return value;
        }
    });

    let name = document.getElementById('name');
    let lastname = document.getElementById('lastname');
    let surname = document.getElementById('surname');
    let note = document.getElementById('note');

    name.value = item.name;
    lastname.value = item.lastname;
    surname.value = item.surname;
    note.value = item.note;

    let departmentList = document.getElementById('inputGroupSelect01');
    let professionList = document.getElementById('inputGroupSelect02');

    let xhr = new XMLHttpRequest();
    xhr.open('GET', '/api/v1/departments');
    xhr.send();

    xhr.onload = () => {
        if (xhr.status === HTTP_OK) {
            let resDepartment = JSON.parse(xhr.responseText);
            for (let i = 0; i < resDepartment.length; i++) {
                let option = document.createElement('option');
                option.innerHTML = resDepartment[i].name;
                if (i===0) {
                    option.selected = true;
                }
                departmentList.appendChild(option);
            }
        }
    };


    let xhr1 = new XMLHttpRequest();
    xhr1.open('GET', '/api/v1/professions');
    xhr1.send();

    xhr1.onload = () => {
        if (xhr1.status === HTTP_OK) {
            let resProfession = JSON.parse(xhr1.responseText);
            console.log(resProfession);
            for (let i = 0; i < resProfession.length; i++) {
                let option = document.createElement('option');
                option.innerHTML = resProfession[i].name;
                if (i===0) {
                    option.selected = true;
                }
                professionList.appendChild(option);
            }
        }
    };
}

function updateItem() {
    let updatedUser = {};

    let xhr = new XMLHttpRequest();
    xhr.open('PUT', '/api/v1/coworkers');
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function () {
        if (xhr.status === 200) {
            let itemInfo = JSON.parse(xhr.responseText);
            let allObj = mainCoworkersTable.children;
        }
    };

    updatedUser.name = document.getElementById('name').value;
    updatedUser.lastname = document.getElementById('lastname').value;
    updatedUser.surname = document.getElementById('surname').value;
    updatedUser.note = document.getElementById('note').value;
    updatedUser.departmentId = document.getElementById('inputGroupSelect01').value;
    updatedUser.professionId = document.getElementById('inputGroupSelect02').value;

    xhr.send(JSON.stringify({
        id: localStorage.getItem('id'),
        name: updatedUser.name.toString(),
        lastname: updatedUser.lastname.toString(),
        surname: updatedUser.lastname.toString(),
        note: updatedUser.note.toString(),
        departmentId: updatedUser.departmentId.toString(),
        professionId: updatedUser.professionId.toString()
    }));

    let neededObj = document.getElementById('element-' + localStorage.getItem('id')).parentElement.parentElement;
    let values = Object.values(updatedUser);
    Array.from(neededObj.children).forEach((value, index) => {
        if (index === 0) return;
        if (index >= 5) return;
        value.innerText = values[index - 1];
    });
    localStorage.removeItem('id');

    document.getElementById('closedata').click();
}

function deleteItem(id, name) {
    let elementId = id.split('-')[1];
    let xhr = new XMLHttpRequest();
    xhr.open('DELETE', '/api/v1/' + name + '?id=' + elementId);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function () {
        if (xhr.status === 200) {
            document.getElementById(id).parentElement.parentElement.remove();
        }
    };

    xhr.send();
}


function getDepartments() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', '/api/v1/departments');
    xhr.send();

    xhr.onload = () => {
        if (xhr.status === HTTP_OK) {
            drawDepartmentsRow(xhr.responseText);
            return xhr.responseText;
        }
    };
}


function getProfessions() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', '/api/v1/professions');
    xhr.send();

    xhr.onload = () => {
        if (xhr.status === HTTP_OK) {
            drawProfessionalsRow(xhr.responseText)
        }
    };
}


function drawDepartmentsRow(response) {
    mainDepartmentsTable.innerText = '';
    let items = JSON.parse(response);
    allItem = JSON.parse(response);
    items.forEach((item, index) => {
        let tr = document.createElement('tr');

        let itemId = document.createElement('td');
        let name = document.createElement('td');
        let note = document.createElement('td');

        let department = document.createElement('td');
        let editPanel = document.createElement('td');
        editPanel.innerHTML = '<a href="#" onclick="goToUpdateModel(this.id)" id="element-' + item.name + '"data-toggle="modal" data-target="#exampleModal2"><i class="fas fa-edit"></i></a>' + '|' + '<a href="#" id="deleteItem-' + item.name + '"  onclick="deleteItem(this.id, this.name)  " name="departments"><i class="fas fa-user-times" ></i> </a>';

        itemId.innerText = index + 1;
        name.innerText = item.name;
        note.innerText = item.note;

        tr.appendChild(itemId);
        tr.appendChild(name);
        tr.appendChild(note);
        tr.appendChild(department);
        tr.appendChild(editPanel);
        mainDepartmentsTable.appendChild(tr);
    });
}


function drawProfessionalsRow(response) {
    mainProfessionsTable.innerText = '';
    let items = JSON.parse(response);
    allItem = JSON.parse(response);
    items.forEach((item, index) => {
        let tr = document.createElement('tr');

        let itemId = document.createElement('td');
        let name = document.createElement('td');
        let note = document.createElement('td');

        let editPanel = document.createElement('td');
        editPanel.innerHTML = '<a href="#" onclick="goToUpdateModel(this.id)" id="element-' + item.name + '"data-toggle="modal" data-target="#exampleModal3"><i class="fas fa-edit"></i></a>' + '|' + '<a href="#" id="deleteItem-' + item.name + '"  onclick="deleteItem(this.id, this.name)" name="professions"><i class="fas fa-user-times" ></i> </a>';

        itemId.innerText = index + 1;
        name.innerText = item.name;
        note.innerText = item.note;

        tr.appendChild(itemId);
        tr.appendChild(name);
        tr.appendChild(note);
        tr.appendChild(editPanel);
        mainProfessionsTable.appendChild(tr);
    });
}


function block() {
    event.preventDefault();
};

