public class Item {
        private int idItemPedido;
        private int idPedido;
        private int idProduto;
        private int quantidade;
        private float precoUnitario;

        public Item(int iditemPedido, int idPedido, int idProduto, int quantidade, float precoUnitario) {
            this.idItemPedido = iditemPedido;
            this.idPedido = idPedido;
            this.idProduto = idProduto;
            this.quantidade = quantidade;
            this.precoUnitario = precoUnitario;
        }

        public Item(int idProduto, int quantidade, float precoUnitario){
            this.idProduto = idProduto;
            this.quantidade = quantidade;
            this.precoUnitario = precoUnitario;

        }

        public float getPrecoUnitario() {
            return precoUnitario;
        }

        public void setPrecoUnitario(float precoUnitario) {
            this.precoUnitario = precoUnitario;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }

        public int getIdProduto() {
            return idProduto;
        }

        public void setIdProduto(int idProduto) {
            this.idProduto = idProduto;
        }

        public int getIdPedido() {
            return idPedido;
        }

        public void setIdPedido(int idPedido) {
            this.idPedido = idPedido;
        }

        public int getIditemPedido() {
            return idItemPedido;
        }

        public void setIditemPedido(int iditemPedido) {
            this.idItemPedido = iditemPedido;
        }

        public double calcularSubtotal(){
            return precoUnitario*quantidade;
        }
    }
