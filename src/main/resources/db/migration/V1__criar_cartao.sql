CREATE TABLE IF NOT EXISTS  cartao(
    id UUID PRIMARY KEY,
    num_cartao VARCHAR(100),
    limite NUMERIC,
    nome_titular VARCHAR(100),
    cpf_titular VARCHAR(11),
    endereco_cobranca VARCHAR(100),
    vencimento DATE,
    bandeira VARCHAR(20),
    tipo VARCHAR(20)
)