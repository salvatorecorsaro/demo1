kubectl create namespace argocd
kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml

Acceso a consola
kubectl get secret argocd-initial-admin-secret -n argocd -o jsonpath="{.data.password}" | base64 -d
amvvo7K3dtRxylre

# Para generar el secret de dockerhub
echo -n 'workshophubdev:iaGenerativa23' | base64

cat dockerconfig.json | base64

