INSERT INTO task (id, deadline, description, duration, finalized, title, department_id, person_allocated_id)
VALUES(nextval('task_sequence'), '2024-08-26T16:30:00', 'Criar todos os endpoints para gerenciar uma tarefa', null, false, 'CRUD para tarefas', 1, null);

-- Tarefa 1: Desenvolver a interface de usuário
INSERT INTO task (id, deadline, description, duration, finalized, title, department_id, person_allocated_id)
VALUES(nextval('task_sequence'), '2024-09-01T10:00:00', 'Desenvolver a interface de usuário para o módulo de tarefas', '2024-08-28T04:00:00', true, 'Desenvolvimento da UI', 2, 3);

-- Tarefa 2: Revisão de código
INSERT INTO task (id, deadline, description, duration, finalized, title, department_id, person_allocated_id)
VALUES(nextval('task_sequence'), '2024-08-28T14:00:00', 'Revisar o código do módulo de autenticação', '2024-08-28T02:00:00', true, 'Code Review', 3, 4);

-- Tarefa 3: Atualizar a documentação
INSERT INTO task (id, deadline, description, duration, finalized, title, department_id, person_allocated_id)
VALUES(nextval('task_sequence'), '2024-09-05T12:00:00', 'Atualizar a documentação do projeto', null, false, 'Atualização da documentação', 1, null);

-- Tarefa 4: Implementar testes unitários
INSERT INTO task (id, deadline, description, duration, finalized, title, department_id, person_allocated_id)
VALUES(nextval('task_sequence'), '2024-08-30T16:00:00', 'Implementar testes unitários para os serviços de tarefa', null, false, 'Testes Unitários', 2, null);

-- Tarefa 5: Configurar o CI/CD
INSERT INTO task (id, deadline, description, duration, finalized, title, department_id, person_allocated_id)
VALUES(nextval('task_sequence'), '2024-09-03T09:00:00', 'Configurar o pipeline de CI/CD para o repositório', null, false, 'Configuração CI/CD', 4, null);
